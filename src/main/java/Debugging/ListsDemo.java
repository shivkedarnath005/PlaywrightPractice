package Debugging;

import java.util.ArrayList;
import java.util.List;

public class ListsDemo
{
    List<String> voterList = new ArrayList<>();

    public ListsDemo()
    {
        voterList.add("V1");
        voterList.add("V2");
        voterList.add("V3");
        voterList.add("V4");
        voterList.add("V5");

    }

    public static void main(String[] args)
    {
        ListsDemo voters = new ListsDemo();

        System.out.println(voters.voterList);
        removeVoters(voters);

    }

    public static void removeVoters(ListsDemo voters) {
        voters.voterList.remove("V1");
        System.out.println(voters.voterList);
    }
}
