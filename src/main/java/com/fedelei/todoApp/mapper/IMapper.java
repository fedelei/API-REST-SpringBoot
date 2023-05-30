package com.fedelei.todoApp.mapper;

public interface IMapper<I, O>{
    public O map(I in);
}
