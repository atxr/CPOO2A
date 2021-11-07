## Java CPOO 2A project 2021/2022 ISAE-SUPAERO

This project was realized for the final individual project of the CPOO 2A course.
Its goal is to realize a **simulation of the production and consumption of a city** in Java.

### Expectations

The excepted behave of the simulation is to generate **daily and annual reports for electricity production and consumption of a city**, represented by injection points - houses, buildings, factories - and producers - nuclear central, solar panel, wind turbine.
The report has to be in **CSV format**.

### Usage

A randomly generated city is already simulated in the Main executable class to test the program behavior.
The CSV files are **generated in the data/ folder** from the root directory.
This code has been designed such as it is simple to add extra production or consumption classes, thanks to the general types Type1 and Type2 classes, that can compute complex behavior.

#### Type1 : Periodic Type

Thanks to Type1, it is easy to generate producers or devices whose power follows a **periodic behavior**.
This simulation also provides two practical classes - ContinuousDevice and ContinuousProducer - to represent a **constant power behavior**.

#### Type2 and Weather : external factors dependency

With Type2, producers and consumers can follow a model that has dependencies on external factors stored in The Weather class. Dependencies are computed with a function that calculates the power according to the weather at a given time. 
Few classes such as WindTurbine, SolarPanel, and Heating are already available in the simulation with Type2.

**Note**: For the clarity of the code, and because this detail is - from my point of view - insignificant regarding the simulation precision, I choose to represent external parameters as Boolean instead of Integer or Float. Indeed, one could think that modeling the temperature or the wind strength would be more precise and logical with a number than with a Boolean.
In a future version of the simulation, this last assertion may be checked.
