package homework_30.to_do_list.to_do_list;

public enum ToDoList {
    ADD_TASK(1, "add task"),VIEW_TASKS(2, "view all tasks"),
    DELETE_TASK(3, "delete task (by number)"), EXIT(4, "exit the menu");

    // field
   private  int optionNumber;
    private  String description;

    ToDoList(int optionNumber, String description) {
        this.optionNumber = optionNumber;
        this.description = description;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ToDoList{");
        sb.append("optionNumber=").append(optionNumber);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
