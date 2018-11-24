package me.zinno.alphabot.delegator.priority;

public @interface Priority {

    float value();

    enum Level {

        HIGHEST(0.5F),
        HIGH(0.3F),
        MEDIUM(0.0F),
        LOW(-0.3F),
        LOWEST(-0.5F);


        private float level;

        Level(float level) {
            this.level = level;
        }

    }

}
