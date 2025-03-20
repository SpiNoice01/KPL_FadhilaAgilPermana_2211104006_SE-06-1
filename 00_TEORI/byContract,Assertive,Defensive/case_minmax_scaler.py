from typing import List

def min_max_scaler(data: List[float]) -> List[float]:
    # Mengubah data ke dalam skala 0-1 menggunakan pendekatan min-max
    # PRecondition: data tidak boleh kosong
    assert len(data) > 0, "Data harus tidak kosong"

    min_val, max_val = min(data), max(data)

    #Postcondition: data diubah menjadi skala 0-1
    assert all(0 <= (x - min_val) / (max_val - min_val) <= 1 for x in data), "Data harus berada diantara 0 dan 1"
    return [(x - min_val) / (max_val - min_val) for x in data]

#Test
sample_data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
scale_data = min_max_scaler(sample_data)

#Invariant and Postcondition
assert all(0 <= x <= 1 for x in scale_data), "Data harus berada diantara 0 dan 1"

print("dataasli: ", sample_data)
print("data setelah diubah: ", scale_data)
