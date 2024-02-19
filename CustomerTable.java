void main() {

    String[][] customers = {
            {"1", "2", "3", "4", "5"},
            {"Kasun", "Nuwan", "Ruwan", "Supun", "Amal"},
            {"077-1234567", "076-1234567", "071-1234567", "072-1234567", "078-1234567"},
            {"011-1234567", "-", null, "033-1234567", "-"},
    };

    final String LINE = STR."+\{"-".repeat(5)}+\{"-".repeat(8)}+\{"-".repeat(12)}+\{"-".repeat(12)}+";
    final String HEADER = "|%-5s|%-8s|%-12s|%-12s|".formatted("ID", "Name", "Contact 1", "Contact 2");
    final String ROW = "|%-5s|%-8s|%-12s|%-12s|\n";

    System.out.println(LINE);
    System.out.println(HEADER);
    System.out.println(LINE);

    int noOfCustomer = customers[0].length;

    // Add customer details to new array 2D array
    // [id, name, contact 1, contact 2]
    String[][] customerDetails = new String[noOfCustomer][4];

    int i = 0;
    for (String[] customerElement : customers) {
        int j = 0;
        for (String details : customerElement) {
            customerDetails[j++][i] = details;
        }
        i++;
    }

    for (String[] customerDetail : customerDetails) {
        String id = customerDetail[0];
        String name = customerDetail[1];
        String contact1 = customerDetail[2];
        String contact2 = customerDetail[3];

        System.out.printf(ROW, getId(id), name, getContactNumber(contact1), getContactNumber(contact2));
    }
    System.out.println(LINE);
}

String getId(String id) {
    return "C-%03d".formatted(Integer.parseInt(id));
}
String getContactNumber(String contact) {
    return contact == null || contact.equals("-") ? "-" : contact;
}
