import main.kotlin.model.Owner
import main.kotlin.model.Pet
import org.junit.Test

/**
 * a quick example of some unit testing
 */
internal class OwnerSorterTest {

    val sorter = OwnerSorter()
    val pets: MutableList<Pet> = mutableListOf(Pet("Fido", "Dog"), Pet("Garfield", "Cat"))

    @Test
    fun shouldHandleNullPets() {
        val owner = Owner("name", 10, "Male", null)
        val owners: MutableList<Owner> = mutableListOf(Owner("testName", 10, "Male", pets), owner)

        sorter.sortCatsByOwnerGender(owners, "Male")
    }

    @Test
    fun shouldSortByMaleAndFemale() {
        val female = Owner("name", 10, "Female", mutableListOf(Pet("catty", "Cat")))
        val male = Owner("testName", 10, "Male", pets)
        val owners: MutableList<Owner> = mutableListOf(male, female)

        val femaleResult = sorter.sortCatsByOwnerGender(owners, "Female")
        val maleResult = sorter.sortCatsByOwnerGender(owners, "Male")

        assert(femaleResult.size == 1 && femaleResult.get(0).name == "catty")
        assert(maleResult.size == 1 && maleResult.get(0).name == "Garfield")
    }

    @Test
    fun shouldFilterOutDogs() {
        val owner = Owner("testName", 100, "Male", pets)
        val result = sorter.sortCatsByOwnerGender(listOf(owner), "Male")

        assert(result.size == 1)
    }

    @Test
    fun shouldSortPetsAlphabetically() {
        val owner = Owner("testName", 100, "Male",
                listOf(Pet("A", "Cat"), Pet("Z", "Cat"), Pet("F", "Cat")))

        val result = sorter.sortCatsByOwnerGender(listOf(owner), "Male")

        assert(result.get(0).name == "A" && result.get(1).name == "F" && result.get(2).name == "Z")
    }
}