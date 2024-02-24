package gkl.exercise.models

import io.micronaut.data.annotation.Embeddable
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.EmbeddedId

@MappedEntity
@Serdeable
data class Reservation(@EmbeddedId var compositeKey: PrimaryComposite, val name: String, val status: Boolean) {
}
@Embeddable
@Serdeable
data class PrimaryComposite(
    @Column(name = "id")
    var id: Long,
    @Column(name = "reserve")
    var reserve: String
)