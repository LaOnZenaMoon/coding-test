package lozm.command.light;

import lozm.command.simple.Command;

// Invoker
public class RemoteControl {

    Command[] onCommands;
    Command[] offCommands;


    public RemoteControl() {
        this.onCommands = new Command[7];
        this.offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }


    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
    }


    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n------ Remote Control ------\n");

        for (int i = 0; i < onCommands.length; i++) {
            stringBuffer.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                    + " " + offCommands[i].getClass().getName() + "\n");
        }

        return stringBuffer.toString();
    }

}