import java.io.Serializable;
import java.util.Objects;

public class Task implements Serializable
{
    private String mName, mDueDate, mDeadline;
    private int mPriority;

    public Task(String name, String dueDate, String deadline, int priority){
        mName = name;
        mDueDate = dueDate;
        mDeadline = deadline;
        mPriority = priority;
    }

    public Task(Task otherTask){
        mName = otherTask.mName;
        mDueDate = otherTask.mDueDate;
        mDeadline = otherTask.mDeadline;
        mPriority = otherTask.mPriority;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDueDate() {
        return mDueDate;
    }

    public void setDueDate(String dueDate) {
        this.mDueDate = dueDate;
    }

    public String getDeadline() {
        return mDeadline;
    }

    public void setDeadline(String deadline) {
        this.mDeadline = deadline;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setPriority(int priority) {
        this.mPriority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return mPriority == task.mPriority && Objects.equals(mName, task.mName) && Objects.equals(mDueDate, task.mDueDate) && Objects.equals(mDeadline, task.mDeadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName, mDueDate, mDeadline, mPriority);
    }

    @Override
    public String toString() {
        String priorityLevel = null;
        if(mPriority == 1)
            priorityLevel = "high";
        else if (mPriority == 2)
            priorityLevel = "medium";
        else if (mPriority == 3)
            priorityLevel = "low";

        return "Task{" + "name='" + mName + '\'' +
                ", dueDate='" + mDueDate + '\'' +
                ", deadline='" + mDeadline + '\'' +
                ", priority=" + priorityLevel +
                '}';
    }
}
