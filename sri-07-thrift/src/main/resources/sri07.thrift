namespace java edu.pja.sri.lab07

exception NotFoundException{
1: string message;
}

service MedicineService {



list<Medicine> getMedicines(),
Medicine getMedicineById(1: i32 id)  throws (1: NotFoundException notFound),
void addMedicine(1: Medicine med),
Medicine getMedicineByName(1: string name)  throws (1: NotFoundException notFound),
Medicine getMedicineByNameDose(1: string name, 2: double dose) throws (1: NotFoundException notFound)
}


struct Medicine {
           1: optional i32 id,
           2: string name,
           3: string api,
           4: double dose
}


