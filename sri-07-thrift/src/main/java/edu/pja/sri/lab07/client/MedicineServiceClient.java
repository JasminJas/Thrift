package edu.pja.sri.lab07.client;

import edu.pja.sri.lab07.Medicine;
import edu.pja.sri.lab07.MedicineService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.List;

public class MedicineServiceClient {
    public static void main(String [] args) {
        try {
            TTransport transport;

            transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            MedicineService.Client medicineServiceClient = new MedicineService.Client(protocol);

            perform(medicineServiceClient, 0, "Ibuprom", "Ibuprofen", 200.0);

            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }

    private static void perform(MedicineService.Client medicineServiceClient, int id, String medicineName, String medicineAPI, double medicineDose) throws TException {

        Medicine med1 = new Medicine(medicineName, medicineAPI, medicineDose);
        medicineServiceClient.addMedicine(med1);

        List<Medicine> allMedicines = medicineServiceClient.getMedicines();

        for(int i = 0; i < allMedicines.size(); i++){
            System.out.println("The list is as follows: " + allMedicines.get(i));
        }

        medicineServiceClient.getMedicines();
        medicineServiceClient.getMedicineById(id);
        medicineServiceClient.getMedicineByName(medicineName);
        medicineServiceClient.getMedicineByNameDose(medicineName, medicineDose);
    }
}

