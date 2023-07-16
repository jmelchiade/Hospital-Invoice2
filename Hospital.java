import javax.swing.JOptionPane;

public class Hospital {
    private String patientId;
    private String patientName;
    private int numDays;
    private char roomType;

    private final double PRIVATE_ROOM_FEE = 550.0;
    private final double SEMIPRIVATE_ROOM_FEE = 350.0;
    private final double WARD_FEE = 105.0;
    private final double TELEPHONE_FEE = 4.5;
    private final double TELEVISION_FEE = 7.5;
    private final double BASE_MEDICATION_FEE = 275.0;

    public Hospital(String patientId, String patientName, int numDays, char roomType) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.numDays = numDays;
        this.roomType = Character.toLowerCase(roomType);
    }

    public void printBillingStatement() {
        double roomCharge = 0.0;
        double telephoneCharge = 0.0;
        double televisionCharge = 0.0;
        double medicationCharge = 0.0;
        String roomTypeName = "";

        switch (roomType) {
            case 'p':
                roomCharge = numDays * PRIVATE_ROOM_FEE;
                roomTypeName = "Private";
                break;
            case 's':
                roomCharge = numDays * SEMIPRIVATE_ROOM_FEE;
                roomTypeName = "Semi-private";
                break;
            case 'w':
                roomCharge = numDays * WARD_FEE;
                roomTypeName = "Ward";
                break;
        }

        if (roomType == 'p') {
            telephoneCharge = TELEPHONE_FEE;
            televisionCharge = TELEVISION_FEE;
            medicationCharge = 2 * BASE_MEDICATION_FEE;
        } else if (roomType == 's') {
            televisionCharge = TELEVISION_FEE;
            medicationCharge = BASE_MEDICATION_FEE;
        } else if (roomType == 'w') {
            medicationCharge = BASE_MEDICATION_FEE / 2;
        }

        double total = roomCharge + telephoneCharge + televisionCharge + medicationCharge;

        String output = "The ABC Community Hospital\n" +
                "    Patient Billing Statement\n" +
                "Patient: \t\t" + patientName + "\n" +
                "Number of days: \t" + numDays + "\n" +
                "Type of room: \t" + roomTypeName + "\n" +
                "Room charge......... \t$" + roomCharge + "\n" +
                "Telephone............. \t$" + telephoneCharge + "\n" +
                "Television............. \t$" + televisionCharge + "\n" +
                "Medication............ \t$" + medicationCharge + "\n" +
                "Total amount due.. \t$" + total;

        JOptionPane.showMessageDialog(null, output);
    }

    public static void main(String[] args) {
        String patientId = JOptionPane.showInputDialog("Enter patient ID:");
        String patientName = JOptionPane.showInputDialog("Enter patient name:");
        int numDays = Integer.parseInt(JOptionPane.showInputDialog("Enter number of days:"));
        char roomType = JOptionPane.showInputDialog("Enter room type (P/p= private, S/s= semi-private, W/w= ward):").charAt(0);

        Hospital hospital = new Hospital(patientId, patientName, numDays, roomType);
        hospital.printBillingStatement();
    }
}
