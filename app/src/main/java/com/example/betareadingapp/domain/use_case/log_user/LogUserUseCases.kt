package com.example.betareadingapp.domain.use_case.log_user

import javax.inject.Inject

class LogUserUseCases
@Inject constructor(
    val getMyTexts: GetMyTexts,
    val getFileNameFromUri: GetFileNameFromUri,
    val uploadNotePdf: UploadNotePdf,
    val addComment : AddComment
)