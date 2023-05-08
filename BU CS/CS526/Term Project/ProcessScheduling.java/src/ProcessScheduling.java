/**
 * Name: Jian Song
 * BU Email: jaysong@bu.edu
 */
import net.datastructures.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.File;
import java.util.Scanner;

public class ProcessScheduling {
    /**
     * this is a public class for instantiating process object.
     */
    public static class Process implements Comparable<Process>{
        private int id;
        private int priority;
        private int duration;
        private int arrivalTime;
        private int remaining;
        private int waitTime;

        public int getWaitTime() {
            return waitTime;
        }

        public void setWaitTime(int waitTime) {
            this.waitTime = waitTime;
        }

        public int getRemaining() {
            return remaining;
        }

        public void setRemaining(int remaining) {
            this.remaining = remaining;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getArrivalTime() {
            return arrivalTime;
        }

        public void setArrivalTime(int arrivalTime) {
            this.arrivalTime = arrivalTime;
        }

        public Process(){

        }
        public Process(int id, int priority, int duration, int arrivalTime){
            this.setId(id);
            this.setPriority(priority);
            this.setDuration(duration);
            this.setArrivalTime(arrivalTime);
        }

        public Process(int id, int priority, int duration, int arrivalTime, int remaining, int waitTime){
            this.setId(id);
            this.setPriority(priority);
            this.setDuration(duration);
            this.setArrivalTime(arrivalTime);
            this.setRemaining(remaining);
            this.setWaitTime(waitTime);
        }


        // override the compareTo method based on arrival time
        @Override
        public int compareTo(Process compareProc){
            int compareArrivalTime = ((Process) compareProc).getArrivalTime();
            // sort in ascending order
            return this.arrivalTime - compareArrivalTime;
        }

        public String toString() {
            String stringInOneLine =
                    "Id = " + getId() + ", " +
                            "priority = " + getPriority() + ", " +
                            "duration = " + getDuration() + ", " +
                            "arrival time = " + getArrivalTime();
            return stringInOneLine;
        }


    }
    public static void main(String[] args) throws IOException {

        // utilize FileWriter to write output file
        FileWriter processSchedulingWriter = new FileWriter("process_scheduling_output.txt");

        // choose arraylist data structure to store the processes that are read from the input file
        List<Process> D = new ArrayList<>();
        //  use Scanner to read the input file
        Scanner input = new Scanner(new File("process_scheduling_input.txt")); // Assumes file path is passed as argument

        // initialize variables
        int id, priority, duration, arrivalTime;
        while (input.hasNextLine()){
            String lineInput = input.nextLine();
            String[] splitLines = lineInput.split(" ");
            id = Integer.parseInt(splitLines[0]);
            priority = Integer.parseInt(splitLines[1].trim());
            duration = Integer.parseInt(splitLines[2].trim());
            arrivalTime = Integer.parseInt(splitLines[3].trim());
            // create new ProcessItems object, the remaining is the same as duration at the beginning
            Process p = new Process(id, priority, duration, arrivalTime, duration, 0);
            D.add(p);
            // print all processes
            System.out.println(p);

            // write to the writer file
            processSchedulingWriter.write(p.toString() );
            processSchedulingWriter.write("\n");
        }

        // close the scanner and add formats to the console and output file
        input.close();
        System.out.println();
        processSchedulingWriter.write("\n");

        // override the compareTo method from the Process class
        // sort the arraylist by arrival time in case it is not aligned with the order of id
        Collections.sort(D);
        // get the number of processes
        int numProcessed = D.size();

        // create an empty priority queue Q from import net.datastructures;
        HeapAdaptablePriorityQueue<Integer, Process> Q = new HeapAdaptablePriorityQueue<>();

        // set the maximum wait time
        int maxWaitTime = 20;
        System.out.println("Maximum wait time = " + maxWaitTime);
        System.out.println();
        processSchedulingWriter.write("Maximum wait time = " + maxWaitTime);
        processSchedulingWriter.write("\n");

        // initialize relevant variables and start the clock
        int currentTime = 0;
        // initialize total wait time for average wait time calculation
        int totalWaitTime = 0;
        Double waitTime = 0.0;
        int remaining = 0;
        int prevId = 0;

        // start the while loop
        // the outer loop serves as a clock by increase currentTime by 1 when execute each loop
        while (!Q.isEmpty() || !D.isEmpty()){
            // initialize a new process
            Process p;
            if (!D.isEmpty()){
                // get the first item from the sorted list for p
                p = D.get(0);
                // whenever arrival time equals current time, add p to Q
                if (p.getArrivalTime() == currentTime){
                    Q.insert(p.getPriority(), p);
                    // the first item of arraylist is always the one that is about to be passed to p and added to Q
                    D.remove(0);
                }
            }

            // initialize a new process of currently running process
            Process currentProcess = new Process();
            if (!Q.isEmpty()){
                // get the top process according to priority
                currentProcess = Q.min().getValue();
                remaining = currentProcess.getRemaining();
                currentProcess.setRemaining(currentProcess.getRemaining() - 1);
                // check if the id from the last loop equals the current one
                int currentId = currentProcess.getId();

                // if not the same id, print
                if (prevId != currentId) {
                    System.out.println("Now running Process id = " + currentProcess.getId());
                    System.out.println("Arrival = " + currentProcess.getArrivalTime());
                    System.out.println("Duration = " + currentProcess.getDuration());
                    System.out.println("Run time left = " + remaining + "\n\t at time " + currentTime);
                    processSchedulingWriter.write("Now running Process id = " + currentProcess.getId() + "\n");
                    processSchedulingWriter.write("Arrival = " + currentProcess.getArrivalTime() + "\n");
                    processSchedulingWriter.write("Duration = " + currentProcess.getDuration() + "\n");
                    processSchedulingWriter.write("Run time left = " + remaining + "\n\t at time " + currentTime + "\n");
                }
                //execute the top process in the priority queue
                System.out.println("Executed process ID: " + currentProcess.getId() +
                        ", at time " + currentTime +
                        " Remaining: " + currentProcess.getRemaining());
                processSchedulingWriter.write("Executed process ID: " + currentProcess.getId() +
                        ", at time " + currentTime +
                        " Remaining: " + currentProcess.getRemaining() + "\n");

                // loop through Q to lower the priorities for all the processes that reach the maxWaitTime
                for (Entry<Integer, Process> process: Q){
                    // create an arraylist to hold all processes in Q
                    ArrayList<Process> updatedWaitTime = new ArrayList<>();
                    updatedWaitTime.add(process.getValue());

                    for (Process processWithUpdatedWaitTime : updatedWaitTime){
                        if (currentId != processWithUpdatedWaitTime.getId()){
                            processWithUpdatedWaitTime.setWaitTime(processWithUpdatedWaitTime.getWaitTime() + 1);
                            waitTime += 1;
                        }

                        // find the processes that reach the maxWaitTime
                        if (processWithUpdatedWaitTime.getWaitTime() == maxWaitTime){
                            // update priorities
                            Q.replaceKey(process, processWithUpdatedWaitTime.getPriority() - 1);
                            System.out.println("Process " + processWithUpdatedWaitTime.getId() +
                                    " reached maximum wait time... " +
                                    "decreasing priority to " + (processWithUpdatedWaitTime.getPriority() - 1));
                            processSchedulingWriter.write("Process " + processWithUpdatedWaitTime.getId() +
                                    " reached maximum wait time... " +
                                    "decreasing priority to " + (processWithUpdatedWaitTime.getPriority() - 1) + "\n");

                            // update the priority
                            processWithUpdatedWaitTime.setPriority(processWithUpdatedWaitTime.getPriority() - 1);
                            // reset the waitTime
                            processWithUpdatedWaitTime.setWaitTime(0);
                        }
                        // update the process's remaining time
                        Q.replaceValue(process, processWithUpdatedWaitTime);
                    }
                }

                // when the process is finished
                if (currentProcess.getRemaining() == 0){
                    System.out.println("Finish running Process id = " + currentProcess.getId());
                    System.out.println("Arrival = " + currentProcess.getArrivalTime());
                    System.out.println("Duration = " + currentProcess.getDuration());
                    System.out.println("Run time left = " + (remaining - 1) + "\n\t at time " + currentTime);
                    System.out.println();
                    processSchedulingWriter.write("Finish running Process id = " + currentProcess.getId() + "\n");
                    processSchedulingWriter.write("Arrival = " + currentProcess.getArrivalTime() + "\n");
                    processSchedulingWriter.write("Duration = " + currentProcess.getDuration() + "\n");
                    processSchedulingWriter.write("Run time left = " + (remaining - 1) + "\n\t at time " + currentTime + "\n");
                    // remove the process
                    Q.removeMin();
                }
            }

            // record the id of the current loop and save for id check operation in next loop
            prevId = currentProcess.getId();
            // increment current time
            currentTime++;
        }

        // calculate the average wait time
        Double averageWaitTime = (waitTime / numProcessed);
        System.out.println("Finished running all processes at time " + (currentTime - 1));
        System.out.println("Average wait time: " + averageWaitTime);
        processSchedulingWriter.write("Finished running all processes at time " + (currentTime - 1) + "\n");
        processSchedulingWriter.write("Average wait time: " + averageWaitTime + "\n");
        processSchedulingWriter.close();
    }
}