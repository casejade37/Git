import pandas as pd

# read data from Excel file
df = pd.read_excel("data.xlsx")

# create a list of mentors and mentees
mentors = df[df["Mentor/Mentee"] == "Mentor"]
mentees = df[df["Mentor/Mentee"] == "Mentee"]

# read existing pairings from file
try:
    existing_pairings = pd.read_excel("mentorship_pairings.xlsx")
    existing_mentors = set(existing_pairings["Mentor"].values)
    existing_mentees = set(existing_pairings["Mentee"].values)
except:
    existing_pairings = pd.DataFrame(columns=["Mentor", "Mentee"])
    existing_mentors = set()
    existing_mentees = set()


# create a dictionary to store the pairings
pairings = {}

# iterate over each mentor
for _, mentor in mentors.iterrows():
    # get the mentor group
    mentor_group = mentor["Mentor Group"]
    # check if the mentor has a mentor group
    if not pd.isnull(mentor_group):
        # get the list of mentees that the mentor can accept
        mentee_pool = mentees[mentees["Preferred Mentor Group"].fillna('').str.split('; ').apply(lambda x: mentor_group in x) | mentees["Preferred Mentor Group"].isnull()]
    else:
        # if the mentor has no mentor group, they can mentor any mentee
        mentee_pool = mentees

    # check if the mentor can accept a second mentee
    if mentor["Second Mentee?"] == "No":
        # remove any existing mentees for this mentor from the mentee pool
        mentee_pool = mentee_pool[mentee_pool["Name"] != mentor["Name"]]
    
    mentee_pool = mentee_pool[mentee_pool["Second Mentee?"].isnull() | (mentee_pool["Second Mentee?"] != "No")]

    # shuffle the mentees in the pool
    mentee_pool = mentee_pool.sample(frac=1)

    # iterate over each mentee in the mentee pool
    for _, mentee in mentee_pool.iterrows():
        # check if this mentor-mentee pair has already been made
        if (mentor["Name"] in existing_mentors and mentee["Name"] in existing_mentees) or (mentee["Name"] in pairings.values() and mentor["Name"] in pairings.keys()):
            continue
        # get the mentee's preferred mentor group
        preferred_mentor_group = mentee["Preferred Mentor Group"]
        # get the mentee's mentor group
        mentee_mentor_group = mentee["Mentor Group"]
        # check if the mentee's preferred mentor group matches the mentor's group
        if preferred_mentor_group == mentor_group:
            # check if the mentor already has a mentee or second mentee
            if mentor["Name"] not in pairings or mentor["Second Mentee?"] != "No":
                # add the mentor-mentee pair to the dictionary
                pairings.setdefault(mentor["Name"], []).append(mentee["Name"])
                # remove the mentee from the mentee pool
                mentees = mentees[mentees["Name"] != mentee["Name"]]
                # check if the mentor already has two mentees
                if mentor["Name"] in pairings and len(pairings[mentor["Name"]]) == 2:
                    break

        # if the mentee's preferred mentor group do not match the mentor's group
        else:
            # check if the mentor already has a mentee or second mentee
            if mentor["Name"] not in pairings or mentor["Second Mentee?"] != "No":
                # add the mentor-mentee pair to the dictionary
                pairings.setdefault(mentor["Name"], []).append(mentee["Name"])
                # remove the mentee from the mentee pool
                mentees = mentees[mentees["Name"] != mentee["Name"]]
                # check if the mentor already has two mentees
                if mentor["Name"] in pairings and len(pairings[mentor["Name"]]) == 2:
                    break

# print the pairings
print(pairings)

# write the pairings to an Excel file
pairings_df = pd.DataFrame(pairings.items(), columns=["Mentor", "Mentee"])
pairings_df.to_excel("mentorship_pairings.xlsx", index=False)
