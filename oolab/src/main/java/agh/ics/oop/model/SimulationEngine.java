package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine implements Runnable {

    private final List<Simulation> simulationList;

    public SimulationEngine(List<Simulation> simulationList) {
        this.simulationList = simulationList;

    }
    public void runSync()  {
        for (Simulation simulation : simulationList) {
            try {
                simulation.run();
            }
            catch (InterruptedException e) {
                System.err.println("Simulation interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    public void runAsync() throws InterruptedException {
        List<Thread> asyncSimulations = new ArrayList<>();
        for (Simulation simulation : simulationList) {
            asyncSimulations.add(new Thread(() -> {
                try {
                    simulation.run();
                } catch (InterruptedException e) {
                    System.err.println("Simulation interrupted: " + e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }));
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
    public void awaitSimulationsEnd(ExecutorService executorService) throws InterruptedException {
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
    public void runAsyncInThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (Simulation simulation : simulationList) {
            executorService.submit(() -> {
                try {
                    simulation.run();
                } catch (InterruptedException e) {
                    System.err.println("Simulation interrupted: " + e.getMessage());
                    Thread.currentThread().interrupt();
                }
            });
        }
        awaitSimulationsEnd(executorService);
    }

    @Override
    public void run() {

    }
}
