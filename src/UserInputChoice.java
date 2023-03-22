public class UserInputChoice {
    private InputChoices inputChoices;

    public UserInputChoice(int choice) {
        switch(choice){
            case 1:
                inputChoices = InputChoices.ADD_A_TODO;
            case 2:
                inputChoices = InputChoices.LIST_ALL_TODOS;
            case 3:
                inputChoices = InputChoices.LIST_ALL_COMPLETED_TODOS;
            case 4:
                inputChoices = InputChoices.LIST_ALL_UNCOMPLETED_TODOS;
            case 5:
                inputChoices = InputChoices.MARK_A_TODO_AS_COMPLETE;
        }
    }

    public InputChoices getInputChoice() {
        return inputChoices;
    }
}
