package assign2.services.userservice;

import assign2.exceptions.FileWriteException;
import assign2.services.memory.Memory;
import assign2.services.storage.Storage;

import java.util.Scanner;

public class Exit {
    public static void run(Scanner sc, Storage storage, Memory memory) throws FileWriteException {
        System.out.println("Do you want to save changes!!");
        System.out.print("Enter yes or no [y/n]");
        String op=sc.nextLine();
        if(op.charAt(0)=='y' || op.charAt(0)=='Y'){
            Save.run(storage,memory);
        }
        System.out.println("Exiting .....");
        System.exit(0);
    }
}
