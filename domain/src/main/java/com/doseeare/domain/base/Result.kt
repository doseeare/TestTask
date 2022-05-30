package com.doseeare.domain.base

sealed class Result<out T, out R> {
    class Success<out T>(val successData: T) : Result<T, Nothing>()
    class Failure<out R : Error>(val errorData: R) : Result<Nothing, R>()
}