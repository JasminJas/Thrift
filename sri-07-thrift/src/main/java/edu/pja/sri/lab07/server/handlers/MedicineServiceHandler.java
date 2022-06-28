package edu.pja.sri.lab07.server.handlers;


import edu.pja.sri.lab07.Medicine;
import edu.pja.sri.lab07.MedicineService;
import edu.pja.sri.lab07.NotFoundException;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

public class MedicineServiceHandler implements MedicineService.Iface {

    private List<Medicine> medicine_list = new ArrayList<>();

    private int index = 0;
    public java.util.List<Medicine> getMedicines() throws org.apache.thrift.TException {
        return medicine_list;
    };

    public Medicine getMedicineById(int id) throws NotFoundException, org.apache.thrift.TException{
//        for(int i = 0; i < medicine_list.size(); i++){
//            if(medicine_list.get(i).id == id){
//                return medicine_list.get(i);
//            }
//        }
        return medicine_list.stream().filter(m -> m.id == id).findFirst().orElseThrow(() -> new NotFoundException("Could not find medicine."));
//        throw new NotFoundException("Could not find medicine.");
    }

    public void addMedicine(Medicine med) throws org.apache.thrift.TException {
        this.medicine_list.add(med);
        med.id = index++;
    };

    public Medicine getMedicineByName(java.lang.String name) throws NotFoundException, org.apache.thrift.TException{
        for(int i = 0; i < medicine_list.size(); i++){
            if(medicine_list.get(i).name.equals(name)){
                return medicine_list.get(i);
            }
        }
        throw new NotFoundException("Could not find medicine with name " + name);
    };

    public Medicine getMedicineByNameDose(java.lang.String name, double dose) throws NotFoundException, org.apache.thrift.TException{
        for(int i = 0; i < medicine_list.size(); i++){
            if(medicine_list.get(i).name.equals(name)){
                if(medicine_list.get(i).dose == dose){
                    return medicine_list.get(i);
                }
            }
        }
        throw new NotFoundException("Could not find medicine with name " + name + " and dose " + dose);
    };
}
