import Card from "../ui/Card"
import classes from './NewMeetupForm.module.css'

function NewMeetupForm() {
    return <Card>
        <form className={classes.form}>
            <div className={classes.control}>
                <label htmlFor="title" >Meetup Title</label>
                <input type='text' required id = 'title'></input>
            </div>
            <div className={classes.control}>
                <label htmlFor="image" >Meetup Title</label>
                <input type='url' required id = 'image'></input>
            </div>
            <div className={classes.control}>
                <label htmlFor="address" >Meetup Title</label>
                <input type='text' required id = 'address'></input>
            </div>
            <div className={classes.control}>
                <label htmlFor="description" >Meetup Title</label>
                <textarea id='description' required rows='5'></textarea>
            </div>
            <div className={classes.actions}>
                <button>Add Meetup</button>
            </div>
        </form>
    </Card>
}

export default NewMeetupForm