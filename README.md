## Java CPOO 2A project 2021/2022 ISAE-SUPAERO

This project has been realized for the final individual project of the CPOO 2A course.
The goal of this project is to realize a simulation of the production and consumption of a city in Java.

### Expectations

The excepted behave of the simulation is to generate daily and annual reports for electricity production and consumption of a city, which is represented by injection points - houses, buildings, factories... - and producers - nuclear central, solar panel, wind turbine...
The production and consumption of the city must be computed in the CSV format, to be easily used for some calculus after the simulation.

### Usage

A randomly generated city is already simulated in the Main executable class, to test the program behavior.
The CSV files are generated in the data/ folder from the root directory.
This code as be designed such as it is simple to add extra production or consumption classes, thanks to the general types Type1 and Type2 classes, that can compute complex behavior.

#### Type1 : Periodic Type

Thanks to the Type1, it is easy to generate producers or devices whose power follows a periodic behavior.
This simulation also provide by default two useful classes - ContinuousDevice and ContinuousProducer - to represent a constant power behavior.

#### Type2 and Weather : external factors dependency

With the Type2, producers and consumers can follow a model that have one or more dependencies on external factors, represented by the Weather class. This dependency is computed thanks to a function that calculate the power according to the weather at a given time. 
*Note*: For the clarity of the code, and because this detail is - from my point of view - insignificant regarding to the simulation precision, I choose to represent external parameters as Boolean, instead of Integer or Float. Indeed, one could think that modeling the temperature or the wind strength would be more precise and logical with a number than with a Boolean.
This assertion could be verified in a future version of the simulation.
