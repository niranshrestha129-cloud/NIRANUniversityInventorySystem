/**
*Thrown when a staff member attempts to take on more inventory items than
 * permitted by the system. Each staff member is restricted to a maximum
 * number of items (defined in {@link StaffMember#MAX_ITEMS}).
 */
public class AssignmentLimitExceededException extends Exception {
    public AssignmentLimitExceededException(String message) {
        super(message);
    }
}
