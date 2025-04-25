from abc import ABC, abstractmethod

# Abstract classes and methods are used to define a common interface for a group of related classes.
class vehicle (ABC):
    @abstractmethod
    def start_engine(self):
        pass

# Concrete classes implement the abstract methods defined in the abstract class.
class car (vehicle):
    def start_engine(self):
        print("Car engine started")

class motorcycle (vehicle):
    def start_engine(self):
        print("Motorcycle engine started")

# Factory function to create instances of the concrete classes based on the input type.
def create_vehicle(vehicle_type):
    if vehicle_type == "car":
        return car()
    elif vehicle_type == "motorcycle":
        return motorcycle()
    else:
        raise ValueError("Unknown vehicle type")

# Example usage
car = create_vehicle("car")
car.start_engine()

motorcycle = create_vehicle("motorcycle")
motorcycle.start_engine()