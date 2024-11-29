package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements Runnable {

    private final List<Simulation> simulationList;

    public SimulationEngine(List<Simulation> simulationList) {
        this.simulationList = simulationList;

    }
    public void runSync(){
        for (Simulation simulation : simulationList) {
            simulation.run();
        }
    }

    public void runAsync() throws InterruptedException {
        List<Thread> asyncSimulations = new ArrayList<>();
        for (Simulation simulation : simulationList) {
            asyncSimulations.add(new Thread(simulation::run));
        }
        for(Thread run : asyncSimulations) {
            run.start();
        }
        awaitSimulationsEnd(asyncSimulations);

    }

    public void awaitSimulationsEnd(List<Thread> threadList) throws InterruptedException {
        for (Thread thread : threadList) {
            thread.join();
        }

    }

    @Override
    public void run() {

    }
}
