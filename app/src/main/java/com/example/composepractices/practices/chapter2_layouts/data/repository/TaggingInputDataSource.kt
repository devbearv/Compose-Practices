package com.example.composepractices.practices.chapter2_layouts.data.repository

import com.example.composepractices.practices.chapter2_layouts.data.models.TaggingInputUser
import javax.inject.Inject

class TaggingInputDataSource @Inject constructor() {

    val users = mutableListOf<TaggingInputUser>(
        TaggingInputUser(
            id = "1",
            fullName = "SpongeBob SquarePants",
            username = "spongebob",
        ),
        TaggingInputUser(
            id = "2",
            fullName = "Patrick Star",
            username = "patrick",
        ),
        TaggingInputUser(
            id = "3",
            fullName = "Squidward Tentacles",
            username = "squidward",
        ),
        TaggingInputUser(
            id = "4",
            fullName = "Eugene H. Krabs",
            username = "mrkrabs",
        ),
        TaggingInputUser(
            id = "5",
            fullName = "Sheldon J. Plankton",
            username = "plankton",
        ),
        TaggingInputUser(
            id = "6",
            fullName = "Karen Plankton",
            username = "karen",
        ),
        TaggingInputUser(
            id = "7",
            fullName = "Sandy Cheeks",
            username = "sandy",
        ),
        TaggingInputUser(
            id = "8",
            fullName = "Mrs. Penelope Puff",
            username = "mrspuff",
        ),
        TaggingInputUser(
            id = "9",
            fullName = "Pearl Krabs",
            username = "pearl",
        ),
        TaggingInputUser(
            id = "10",
            fullName = "Gary Wilson",
            username = "gary",
        ),
    )

}