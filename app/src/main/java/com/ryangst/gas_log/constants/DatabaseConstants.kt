package com.ryangst.gas_log.constants

class DatabaseConstants private constructor() {

    companion object {
        const val DATABASE_NAME = "fuel.db"
        const val DATABASE_VERSION = 1
    }

    object FUEL {
        const val FUEL_TABLE_NAME = "Fuel"
        const val FUEL_COLUMN_ID = "id"
        const val FUEL_COLUMN_NAME = "name"
        const val FUEL_COLUMN_PRICE = "price"
    }

    object SUPPLY_RECORDS {
        const val SUPPLY_RECORDS_TABLE_NAME = "SupplyRecords"
        const val SUPPLY_RECORDS_COLUMN_ID = "id"
        const val SUPPLY_RECORDS_COLUMN_DATE = "date"
        const val SUPPLY_RECORDS_COLUMN_AMOUNT = "amount"
        const val SUPPLY_RECORDS_COLUMN_TOTAL = "total"
        const val SUPPLY_RECORDS_COLUMN_CITY = "city"
        const val SUPPLY_RECORDS_COLUMN_FUEL_ID = "fuel_id"
    }
}