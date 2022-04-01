package assign2.services.memory;

import assign2.enums.Field;
import assign2.enums.Order;
import assign2.models.User;
import assign2.utils.Comparators;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MemoryImpl implements Memory{

    private List<User> users;

    public MemoryImpl() {
        users=new ArrayList<>();
    }

    @Override
    public void save(User... users) {
        if(users.length<=1){
            for(int i=0;i<this.users.size();i++){
                if(this.users.get(i).getName().compareToIgnoreCase(users[0].getName())>=0){
                    this.users.add(i,users[0]);
                    return;
                }
            }
            this.users.add(users[0]);
        } else {
            for(User u:users){
                this.users.add(u);
            }
            Collections.sort(this.users,new Comparators.NameComparator());
        }
    }

    @Override
    public List<User> readAll(Field field, Order order) {
        List<User> retUsers=users;
        switch (field){
            case AGE:
                Comparators.AgeComparator comp=new Comparators.AgeComparator();
                Collections.sort(retUsers,comp);
            case ADDRESS:
                Comparators.AddressComparator comp1=new Comparators.AddressComparator();
                Collections.sort(retUsers,comp1);
            case ROLL:
                Comparators.RollNumComparator comp2=new Comparators.RollNumComparator();
                Collections.sort(retUsers,comp2);
        }
        if(order==Order.DESC){
            Collections.reverse(retUsers);
        }
        return retUsers;
    }

    @Override
    public User read(String rollNum) {
        for(User u:this.users){
            if(u.getRollNum().equals(rollNum)){
                return u;
            }
        }
        return null;
    }

    @Override
    public User delete(String rollNum) {
        for(User u:this.users){
            if(u.getRollNum().equals(rollNum)){
                User del=u;
                this.users.remove(u);
                return del;
            }
        }
        return null;
    }
}
