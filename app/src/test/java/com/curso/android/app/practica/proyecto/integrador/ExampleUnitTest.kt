import com.curso.android.app.practica.proyecto.integrador.view.MyViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

class MyViewModelTest {
    private lateinit var viewModel: MyViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = MyViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun validateAndSetResult_emptyTexts_returnsEmptyMessage() {
        val result = viewModel.compareTexts("", "")
        assertEquals("Uno o ambos textos están vacíos", result)
    }

    @Test
    fun validateAndSetResult_equalTexts_returnsEqualMessage() {
        val result = viewModel.compareTexts("texto", "texto")
        assertEquals("Los textos son iguales", result)
    }

    @Test
    fun validateAndSetResult_differentTexts_returnsDifferentMessage() {
        val result = viewModel.compareTexts("texto1", "texto2")
        assertEquals("Los textos no son iguales", result)
    }
}