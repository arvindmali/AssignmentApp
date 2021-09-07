package com.example.testdemo.pojo

class MProductCatDTO {

    constructor(noOfGrid: Int, proItem: ArrayList<MProductDTO>) {
        this.noOfGrid = noOfGrid
        this.proItem = proItem
    }

    var noOfGrid: Int = 3
    lateinit var proItem: ArrayList<MProductDTO>
}