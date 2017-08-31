import main.kotlin.model.Owner
import main.kotlin.model.Pet

/**
 * This is a contrived class for the purpose of creating some unit tests
 */
class OwnerSorter {

    fun sortCatsByOwnerGender(owners: ArrayList<Owner>, gender: String): List<Pet> {
        val pets = owners.filter { it.gender == gender }
                .filter { it.pets != null }
                .flatMap { it.pets!!.filter { it.type == "Cat" } }

        return pets.sortedWith(compareBy({ it.name }))
    }
}