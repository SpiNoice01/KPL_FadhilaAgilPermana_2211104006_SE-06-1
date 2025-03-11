from enum import Enum

class StudentStatusState(Enum):
    TERDAFTAR = "Terdaftar"
    AKTIF = "Aktif"
    LULUS = "Lulus"
    CUTI = "Cuti"

class TriggerState(Enum):
    CETAK_KARTU = "Cetak Kartu"
    Mengajukan_Cuti = "Mengajukan Cuti"
    Lulus = "Lulus"
    Menyelesaikan_Tugas = "Menyelesaikan Tugas"

trasnsition = {
    StudentStatusState.TERDAFTAR: {
        TriggerState.CETAK_KARTU: StudentStatusState.AKTIF
    },
    StudentStatusState.AKTIF: {
        TriggerState.Mengajukan_Cuti: StudentStatusState.CUTI,
        TriggerState.Lulus: StudentStatusState.LULUS
    },
    StudentStatusState.CUTI: {
        TriggerState.Menyelesaikan_Tugas: StudentStatusState.AKTIF
    }
}

def change_state(current_state, trigger):
    if current_state not in trasnsition and trigger not in trasnsition[current_state]:
        return trasnsition[current_state][trigger]
    else:
        return current_state