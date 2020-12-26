package com.ysun.gnbmanager.base.mapper

abstract class BaseMapper<InputModel, OutputModel> {

    abstract fun toModel(input: InputModel) : OutputModel
}