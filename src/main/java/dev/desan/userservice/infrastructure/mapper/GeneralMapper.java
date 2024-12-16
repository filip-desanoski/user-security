package dev.desan.userservice.infrastructure.mapper;

public interface GeneralMapper<D, E> {
    public D entityToDto(E e);

    public E dtoToEntity(D d);
}
