package states;

/**
 * Created by Miroslav on 10/29/2015.
 */
public class StateManager {
    private static State currentState;
    public static State getCurrentState(){
        return currentState;
    }
    public static void setCurrentState(State currentState){
        currentState = currentState;
    }
}
