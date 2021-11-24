package com.example.jetpack_compose_paging3.remote

data class UsersDto(
    val `data`: List<DataDto>,
    val page: Int,
    val per_page: Int,
    val support: SupportDto,
    val total: Int,
    val total_pages: Int
)