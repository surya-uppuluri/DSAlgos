package surya.practice.geeks.linkedList;

public class EmptyListException extends Throwable {
    public EmptyListException(String the_list_is_empty) {
        super(the_list_is_empty);
    }
}
