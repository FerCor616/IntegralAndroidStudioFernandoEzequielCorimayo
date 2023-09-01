import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.curso.android.app.practica.proyecto.integrador.MainActivity
import com.curso.android.app.practica.proyecto.integrador.R
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun compareTexts_emptyTexts_displaysEmptyMessage() {
        onView(withId(R.id.buttonCompare)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("Uno o ambos textos están vacíos")))
    }

    @Test
    fun compareTexts_equalTexts_displaysEqualMessage() {
        onView(withId(R.id.editText1)).perform(typeText("texto"))
        onView(withId(R.id.editText2)).perform(typeText("texto"))
        onView(withId(R.id.buttonCompare)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("Los textos son iguales")))
    }

    @Test
    fun compareTexts_differentTexts_displaysDifferentMessage() {
        onView(withId(R.id.editText1)).perform(typeText("texto1"))
        onView(withId(R.id.editText2)).perform(typeText("texto2"))
        onView(withId(R.id.buttonCompare)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("Los textos no son iguales")))
    }
}