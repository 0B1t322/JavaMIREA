package ru.demin.pract13_1;

public class ListCmd implements CommandsHandler{

    @Override
    public void makeCommand(java.util.List<String> someList, String[] args) {
        if(args.length != 0) {
            System.out.println("LIST had not args");
            return;
        } else {
            for(int i = 0; i < someList.size(); i++) {
                System.out.printf("%s: %s\n", i, someList.get(i));
            }
        }
    }

    @Override
    public void makeCommand(java.util.List<String> someList) {
        return;
    }
}
