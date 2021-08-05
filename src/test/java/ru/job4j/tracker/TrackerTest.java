package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll()[0];
        assertThat(result.getName(), is(first.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item[] result = tracker.findByName(first.getName());
        assertThat(result.length, is(3));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item[] result = tracker.findByName(second.getName());
        assertThat(result[1].getName(), is(second.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenItemAdded() {
        Output output = new StubOutput();
        String[] answer = {"Fix PC"};
        Input input = new StubInput(answer);
        Tracker tracker = new Tracker();
        CreateAction createAction = new CreateAction(output);
        createAction.execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), /* id сохраненной заявки в объект tracker. */
                "replaced item"
        };
        ReplaceAction replaceAction = new ReplaceAction(output);
        replaceAction.execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answer = {
                String.valueOf(item.getId())};
        DeleteAction deleteAction = new DeleteAction(output);
        deleteAction.execute(new StubInput(answer), tracker);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted, is(nullValue()));
    }

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item Name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item Name"));
    }

    @Test
    public void whenReplaceItemV2() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String id = String.valueOf(item.getId());
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0" , id, replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItemV2() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0" , id, "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllItems() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("ShowTestItem"));
        Input in = new StubInput(new String[] {"0", "1"});
        UserAction[] actions = {
                new ShowAllAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("ShowTestItem"));
    }

    @Test
    public void whenFindIdAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("IDTestItem"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(new String[] {"0", id, "1"});
        String rsl = String.valueOf(tracker.findById(item.getId()).getName());
        UserAction[] actions = {
                new FindIdAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(rsl, is("IDTestItem"));
    }

    @Test
    public void whenFindNameAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("NamedItem"));
        String name = item.getName();
        Input in = new StubInput(new String[] {"0", name, "1"});
        String rsl = String.valueOf(tracker.findById(item.getId()).getName());
        UserAction[] actions = {
                new FindNameAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(rsl, is("NamedItem"));
    }
}