from enum import Enum

class TrafficLightState(Enum):
    RED = "Merah"
    YELLOW = "Kuning"
    GREEN = "Hijau"

state_transition = {
    TrafficLightState.RED: TrafficLightState.GREEN,
    TrafficLightState.YELLOW: TrafficLightState.RED,
    TrafficLightState.GREEN: TrafficLightState.YELLOW,
}

state_duration = {
    TrafficLightState.RED: 10,
    TrafficLightState.YELLOW: 5,
    TrafficLightState.GREEN: 15
}

current_state = TrafficLightState.RED
next_state = state_transition[current_state]
print(f"Next State: {next_state}")

while True:
    print(f"{current_state.name} -> {next_state.name}")
    current_state = next_state
    next_state = state_transition[current_state]