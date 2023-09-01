package com.curso.android.app.practica.proyecto.integrador.view
import com.curso.android.app.practica.proyecto.integrador.model.Compare
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val compare: LiveData<Compare> get() = _compare
    private var _compare = MutableLiveData<Compare>(Compare("","","estado"))
    //realizar validar
    fun compareTexts(texto1: String, texto2: String) {
        setCompare(texto1, texto2)
    }
    private fun validateAndSetResult(texto1: String, texto2: String):String {
        if (texto1 != "" && texto2 != "") {

                if (sonIguales(texto1, texto2)) {
                    return "Los textos son iguales"
                } else {
                    return "Los textos no son iguales"
                }

        } else {
            return "Uno o ambos textos están vacíos"
        }
    }

    private fun sonIguales(texto1: String, texto2: String): Boolean {
        return texto1 == texto2
    }

    private fun setCompare(texto1: String, texto2: String) {
        var resul = validateAndSetResult(texto1,texto2)
        _compare.value = Compare(texto1, texto2,resul)

    }
}
