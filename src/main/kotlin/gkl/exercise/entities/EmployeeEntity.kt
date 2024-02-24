package gkl.exercise.entities


import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Serdeable
@Entity
@Table(name="Employee")
class EmployeeEntity{

    @Id
    @Column(name="id")
    var id : Long = 0

    @Column(name="name")
    var name : String = ""

    constructor(id : Long,name : String){
        this.id=id
        this.name=name
    }

    constructor(){

    }

}

