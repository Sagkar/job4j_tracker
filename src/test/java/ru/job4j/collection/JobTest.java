package ru.job4j.collection;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenComparatorAscByName() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Bbb",2));
        jobs.add(new Job("Ccc",3));
        jobs.add(new Job("Aaa",1));
        List<Job> expected = new ArrayList<>();
        expected.add(new Job("Aaa",1));
        expected.add(new Job("Bbb",2));
        expected.add(new Job("Ccc",3));
        Collections.sort(jobs, new JobAscByName());
        assertThat(expected, Matchers.is(jobs));
    }

    @Test
    public void whenComparatorAskByPriority() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Bbb",2));
        jobs.add(new Job("Ccc",3));
        jobs.add(new Job("Aaa",1));
        List<Job> expected = new ArrayList<>();
        expected.add(new Job("Aaa",1));
        expected.add(new Job("Bbb",2));
        expected.add(new Job("Ccc",3));
        Collections.sort(jobs, new JobAscByPriority());
        assertThat(expected, Matchers.is(jobs));
    }

    @Test
    public void whenComparatorDeskByName() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Bbb",2));
        jobs.add(new Job("Ccc",3));
        jobs.add(new Job("Aaa",1));
        List<Job> expected = new ArrayList<>();
        expected.add(new Job("Ccc",3));
        expected.add(new Job("Bbb",2));
        expected.add(new Job("Aaa",1));
        Collections.sort(jobs, new JobDescByName());
        assertThat(expected, Matchers.is(jobs));
    }

    @Test
    public void whenComparatorDeskByPriority() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Bbb",2));
        jobs.add(new Job("Ccc",3));
        jobs.add(new Job("Aaa",1));
        List<Job> expected = new ArrayList<>();
        expected.add(new Job("Ccc",3));
        expected.add(new Job("Bbb",2));
        expected.add(new Job("Aaa",1));
        Collections.sort(jobs, new JobDescByPriority());
        assertThat(expected, Matchers.is(jobs));
    }

    @Test
    public void whenCompatorDescByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorAscBySameNamesAndPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Aaa", 0),
                new Job("Aaa", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorDescBySameNamesAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Aaa", 0),
                new Job("Aaa", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}