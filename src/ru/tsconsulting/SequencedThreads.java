package ru.tsconsulting;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class SequencedThreads {

    private static final int NWORKERS = 5;

    public static void main(String[] args) throws InterruptedException {
        final BlockingQueue<Response> responses = new ArrayBlockingQueue<>(1);
        final Worker[] workers = new Worker[NWORKERS];
        for (int i = 0; i < NWORKERS; i++) {
            final Worker w = new Worker(i, responses);
            workers[i] = w;
            new Thread(w, "Thread #" + i).start();
        }
        for (int i = 0; i < 20; i++) {
            final int workerId = i % NWORKERS;
            workers[workerId].send(new Request(i));
            System.out.println(responses.take().getContent());
        }
        System.exit(0);
    }

    static final class Request {

        private final int id;

        public Request(final int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    static final class Response {

        private final String content;

        public Response(final String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }

    static final class Worker implements Runnable {

        private final int id;
        private final BlockingQueue<Request> requests;
        private final BlockingQueue<Response> responses;

        public Worker(
                final int id,
                final BlockingQueue<Response> responses
        ) {
            this.id = id;
            this.requests = new ArrayBlockingQueue<>(1);
            this.responses = responses;
        }

        public void send(final Request r) throws InterruptedException {
            requests.put(r);
        }

        @Override
        public void run() {
            try {
                while (true) {
                    final Request r = requests.take();
                    final String msg = String.format("Worker #%d message #%d", id, r.getId());
                    responses.put(new Response(msg));
                }
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}