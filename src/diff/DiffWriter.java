package diff;

public class DiffWriter {
    String array1[];
    String array2[];
    int length = 0;


    public DiffWriter(String[] array1, String[] array2) {
        this.array1 = array1;
        this.array2 = array2;
        write();
    }

    public void write() {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int diff = 0;
        int array1length = array1.length;
        int array2length = array2.length;

        if (array2length > array1length) {
            length = array1length;
            diff = array2length - length;
        } else {
            length = array2length;
            diff = array1length - length;
        }

        for (int i = 0; i < length; i++) {
            if (!array1[i].equals(array2[i])) {
                sb1.append(array1[i]);
                sb2.append(array2[i]);
                sb1.append(System.lineSeparator());
                sb2.append(System.lineSeparator());
            }
        }
            if (array1length != length) {
                for (int i = length; i < length + diff; i++) {
                    sb1.append(array1[i]);
                    sb1.append(System.lineSeparator());
                }
            } else {
                for (int i = length; i < length + diff; i++) {
                    sb2.append(array2[i]);
                    sb2.append(System.lineSeparator());
                }
            }
        String everything1 = sb1.toString();
        System.out.println(everything1);
        String everything2 = sb2.toString();
        System.out.println(everything2);
    }
}
