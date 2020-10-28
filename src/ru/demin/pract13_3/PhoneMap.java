package ru.demin.pract13_3;

import ru.demin.pract13_1.Commands;
import ru.demin.pract13_1.CommandsHandler;

import java.util.HashMap;

public class PhoneMap {
    private HashMap<String, String> phoneMap;
    private Commands<CommandsHandler> commands;

    public PhoneMap() {
        phoneMap = new HashMap<>();
        commands = new Commands<>();

        commands.addCommand("LIST", new ListCmd());
    }

    public void ReadCommand(String command , String[] args) {
        try {
            commands.getCommand(command).makeCommand(phoneMap, args);
        } catch (NullPointerException e) {
            System.out.println("Unkown command");
            return;
        }
    }

    public void addWrite(String phoneNumber, String name) {
        phoneMap.put(phoneNumber, name);
    }

    public boolean checkIsExsistPhoneNumber(String phoneNumber) {
        return phoneMap.containsKey(phoneNumber);
    }

    public void printInfo(String phoneNumber) {
        String name = phoneMap.get(phoneNumber);
        System.out.printf("%s - %s\n", name, phoneNumber);
    }

    public boolean checkIfExistName(String name) {
        return phoneMap.containsValue(name);
    }

    public void printInfoByName(String name) {
        for(var key: phoneMap.keySet()) {
            if(phoneMap.get(key).equals(name)) {
                System.out.printf("%s - %s\n", name, key);
            }
        }
    }

    public boolean ifCommandExsist(String command) {
        return commands.ifCommandExsist(command);
    }
}
