package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Change item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Replace item ====");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.replace(id, item);
        if (tracker.replace(id, item)) {
            out.println("Заявка изменена: " + item);
        } else {
            out.println("Ошибка, такой заявки не существует");
        }
        return true;
    }
}
