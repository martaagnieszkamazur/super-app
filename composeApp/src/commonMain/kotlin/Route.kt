import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

object Route {

    @Serializable
    object Main : NavKey

    @Serializable
    object StepsCounter : NavKey

    @Serializable
    object NutriPulse : NavKey

    @Serializable
    object Test : NavKey

    @Serializable
    sealed interface StepsCounterNav : NavKey {

        @Serializable
        object Home : StepsCounterNav

        @Serializable
        object Journal : StepsCounterNav

        @Serializable
        object Profile : StepsCounterNav

        @Serializable
        object AddSteps : StepsCounterNav
    }

    @Serializable
    sealed interface NutriPulseNav : NavKey {

        @Serializable
        object Home: NutriPulseNav

        @Serializable
        object AddMeal: NutriPulseNav

        @Serializable
        object AddIngredient: NutriPulseNav

        @Serializable
        object IngredientsLibrary: NutriPulseNav

        @Serializable
        object Journal: NutriPulseNav

        @Serializable
        object Profile: NutriPulseNav
    }

    val config = SavedStateConfiguration {
        serializersModule = SerializersModule {
            polymorphic(NavKey::class) {
                subclass(Main::class, Main.serializer())
                subclass(StepsCounter::class, StepsCounter.serializer())
                subclass(NutriPulse::class, NutriPulse.serializer())
                subclass(Test::class, Test.serializer())
                subclass(StepsCounterNav.Home::class, StepsCounterNav.Home.serializer())
                subclass(StepsCounterNav.Journal::class, StepsCounterNav.Journal.serializer())
                subclass(StepsCounterNav.Profile::class, StepsCounterNav.Profile.serializer())
                subclass(StepsCounterNav.AddSteps::class, StepsCounterNav.AddSteps.serializer())
                subclass(NutriPulseNav.Home::class, NutriPulseNav.Home.serializer())
                subclass(NutriPulseNav.AddMeal::class, NutriPulseNav.AddMeal.serializer())
                subclass(NutriPulseNav.AddIngredient::class, NutriPulseNav.AddIngredient.serializer())
                subclass(NutriPulseNav.IngredientsLibrary::class, NutriPulseNav.IngredientsLibrary.serializer())
                subclass(NutriPulseNav.Journal::class, NutriPulseNav.Journal.serializer())
                subclass(NutriPulseNav.Profile::class, NutriPulseNav.Profile.serializer())
            }
        }
    }
}