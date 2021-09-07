package com.example.testdemo.pojo

class MProductDTO {
    var proName: String = ""
    var mrp: String = ""
    var dmart: String = ""
    var save: String = ""
    var proImage: String = ""
    var id: Int = 1

    constructor() {}
    constructor(
        proName: String,
        mrp: String,
        dmart: String,
        save: String,
        proImage: String,
        id: Int
    ) {
        this.proName = proName
        this.mrp = mrp
        this.dmart = dmart
        this.save = save
        this.proImage = proImage
        this.id = id
    }
}