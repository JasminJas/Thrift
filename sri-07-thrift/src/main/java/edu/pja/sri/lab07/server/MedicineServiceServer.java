package edu.pja.sri.lab07.server;

import edu.pja.sri.lab07.MedicineService;
import edu.pja.sri.lab07.server.handlers.MedicineServiceHandler;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class MedicineServiceServer {

    public static MedicineServiceHandler medicineServiceHandler;
    public static MedicineService.Processor processorMedicineService;

    public static void main(String [] args) {
        try {
            medicineServiceHandler = new MedicineServiceHandler();
            processorMedicineService = new MedicineService.Processor(medicineServiceHandler);

            Runnable simple = new Runnable() {
                public void run() {
                    simple(processorMedicineService);
                }
            };

            new Thread(simple).start();
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public static void simple(MedicineService.Processor medicineServiceProcessor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(medicineServiceProcessor));

            System.out.println("Starting the simple server...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

