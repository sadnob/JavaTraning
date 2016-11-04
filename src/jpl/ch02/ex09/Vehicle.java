package jpl.ch02.ex09;

public class Vehicle {

        public final long Id;
        public String owner;
        public double speed;
        public double direction;

        public static long nextId = 1;

        Vehicle () {
                this.Id = nextId++;
        }

        Vehicle (String name) {
                this();
                this.owner = name;
        }

        /**
         * 現在使われている識別番号の最大値を得ます。
         */
        static long getMaxId() {
                return nextId-1;
        }

}
