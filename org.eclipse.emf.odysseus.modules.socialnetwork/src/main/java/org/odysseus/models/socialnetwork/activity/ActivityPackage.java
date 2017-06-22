/**
 */
package org.odysseus.models.socialnetwork.activity;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.odysseus.models.socialnetwork.activity.ActivityFactory
 * @model kind="package"
 * @generated
 */
public interface ActivityPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "activity";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.odysseus.socialnetwork.activity";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "activity";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActivityPackage eINSTANCE = org.odysseus.models.socialnetwork.activity.impl.ActivityPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.odysseus.models.socialnetwork.activity.impl.ContributionImpl <em>Contribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.models.socialnetwork.activity.impl.ContributionImpl
	 * @see org.odysseus.models.socialnetwork.activity.impl.ActivityPackageImpl#getContribution()
	 * @generated
	 */
	int CONTRIBUTION = 3;

	/**
	 * The feature id for the '<em><b>Author</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__AUTHOR = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__DATE = 1;

	/**
	 * The number of structural features of the '<em>Contribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Contribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.odysseus.models.socialnetwork.activity.impl.PostImpl <em>Post</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.models.socialnetwork.activity.impl.PostImpl
	 * @see org.odysseus.models.socialnetwork.activity.impl.ActivityPackageImpl#getPost()
	 * @generated
	 */
	int POST = 0;

	/**
	 * The feature id for the '<em><b>Author</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST__AUTHOR = CONTRIBUTION__AUTHOR;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST__DATE = CONTRIBUTION__DATE;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST__TEXT = CONTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Repost Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST__IS_REPOST_OF = CONTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attached Media</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST__ATTACHED_MEDIA = CONTRIBUTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mentions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST__MENTIONS = CONTRIBUTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>In Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST__IN_GROUP = CONTRIBUTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST__VISIBILITY = CONTRIBUTION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Reactions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST__REACTIONS = CONTRIBUTION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST__COMMENTS = CONTRIBUTION_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Post</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_FEATURE_COUNT = CONTRIBUTION_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Post</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_OPERATION_COUNT = CONTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.odysseus.models.socialnetwork.activity.impl.ResponseImpl <em>Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.models.socialnetwork.activity.impl.ResponseImpl
	 * @see org.odysseus.models.socialnetwork.activity.impl.ActivityPackageImpl#getResponse()
	 * @generated
	 */
	int RESPONSE = 4;

	/**
	 * The feature id for the '<em><b>Author</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE__AUTHOR = CONTRIBUTION__AUTHOR;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE__DATE = CONTRIBUTION__DATE;

	/**
	 * The feature id for the '<em><b>Post</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE__POST = CONTRIBUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_FEATURE_COUNT = CONTRIBUTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_OPERATION_COUNT = CONTRIBUTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.odysseus.models.socialnetwork.activity.impl.ReactionImpl <em>Reaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.models.socialnetwork.activity.impl.ReactionImpl
	 * @see org.odysseus.models.socialnetwork.activity.impl.ActivityPackageImpl#getReaction()
	 * @generated
	 */
	int REACTION = 1;

	/**
	 * The feature id for the '<em><b>Author</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION__AUTHOR = RESPONSE__AUTHOR;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION__DATE = RESPONSE__DATE;

	/**
	 * The feature id for the '<em><b>Post</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION__POST = RESPONSE__POST;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION__TYPE = RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_FEATURE_COUNT = RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Reaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_OPERATION_COUNT = RESPONSE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.odysseus.models.socialnetwork.activity.impl.CommentImpl <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.models.socialnetwork.activity.impl.CommentImpl
	 * @see org.odysseus.models.socialnetwork.activity.impl.ActivityPackageImpl#getComment()
	 * @generated
	 */
	int COMMENT = 2;

	/**
	 * The feature id for the '<em><b>Author</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__AUTHOR = RESPONSE__AUTHOR;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__DATE = RESPONSE__DATE;

	/**
	 * The feature id for the '<em><b>Post</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__POST = RESPONSE__POST;

	/**
	 * The feature id for the '<em><b>In Response To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__IN_RESPONSE_TO = RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__TEXT = RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = RESPONSE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_OPERATION_COUNT = RESPONSE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.odysseus.models.socialnetwork.activity.ReactionType <em>Reaction Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.models.socialnetwork.activity.ReactionType
	 * @see org.odysseus.models.socialnetwork.activity.impl.ActivityPackageImpl#getReactionType()
	 * @generated
	 */
	int REACTION_TYPE = 5;

	/**
	 * The meta object id for the '{@link org.odysseus.models.socialnetwork.activity.Visibility <em>Visibility</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.odysseus.models.socialnetwork.activity.Visibility
	 * @see org.odysseus.models.socialnetwork.activity.impl.ActivityPackageImpl#getVisibility()
	 * @generated
	 */
	int VISIBILITY = 6;


	/**
	 * Returns the meta object for class '{@link org.odysseus.models.socialnetwork.activity.Post <em>Post</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Post
	 * @generated
	 */
	EClass getPost();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.models.socialnetwork.activity.Post#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Post#getText()
	 * @see #getPost()
	 * @generated
	 */
	EAttribute getPost_Text();

	/**
	 * Returns the meta object for the reference '{@link org.odysseus.models.socialnetwork.activity.Post#getIsRepostOf <em>Is Repost Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Is Repost Of</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Post#getIsRepostOf()
	 * @see #getPost()
	 * @generated
	 */
	EReference getPost_IsRepostOf();

	/**
	 * Returns the meta object for the reference list '{@link org.odysseus.models.socialnetwork.activity.Post#getAttachedMedia <em>Attached Media</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attached Media</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Post#getAttachedMedia()
	 * @see #getPost()
	 * @generated
	 */
	EReference getPost_AttachedMedia();

	/**
	 * Returns the meta object for the reference list '{@link org.odysseus.models.socialnetwork.activity.Post#getMentions <em>Mentions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mentions</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Post#getMentions()
	 * @see #getPost()
	 * @generated
	 */
	EReference getPost_Mentions();

	/**
	 * Returns the meta object for the reference '{@link org.odysseus.models.socialnetwork.activity.Post#getInGroup <em>In Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In Group</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Post#getInGroup()
	 * @see #getPost()
	 * @generated
	 */
	EReference getPost_InGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.models.socialnetwork.activity.Post#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Post#getVisibility()
	 * @see #getPost()
	 * @generated
	 */
	EAttribute getPost_Visibility();

	/**
	 * Returns the meta object for the reference list '{@link org.odysseus.models.socialnetwork.activity.Post#getReactions <em>Reactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reactions</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Post#getReactions()
	 * @see #getPost()
	 * @generated
	 */
	EReference getPost_Reactions();

	/**
	 * Returns the meta object for the reference list '{@link org.odysseus.models.socialnetwork.activity.Post#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Comments</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Post#getComments()
	 * @see #getPost()
	 * @generated
	 */
	EReference getPost_Comments();

	/**
	 * Returns the meta object for class '{@link org.odysseus.models.socialnetwork.activity.Reaction <em>Reaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reaction</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Reaction
	 * @generated
	 */
	EClass getReaction();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.models.socialnetwork.activity.Reaction#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Reaction#getType()
	 * @see #getReaction()
	 * @generated
	 */
	EAttribute getReaction_Type();

	/**
	 * Returns the meta object for class '{@link org.odysseus.models.socialnetwork.activity.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for the reference '{@link org.odysseus.models.socialnetwork.activity.Comment#getInResponseTo <em>In Response To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In Response To</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Comment#getInResponseTo()
	 * @see #getComment()
	 * @generated
	 */
	EReference getComment_InResponseTo();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.models.socialnetwork.activity.Comment#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Comment#getText()
	 * @see #getComment()
	 * @generated
	 */
	EAttribute getComment_Text();

	/**
	 * Returns the meta object for class '{@link org.odysseus.models.socialnetwork.activity.Contribution <em>Contribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contribution</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Contribution
	 * @generated
	 */
	EClass getContribution();

	/**
	 * Returns the meta object for the reference '{@link org.odysseus.models.socialnetwork.activity.Contribution#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Author</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Contribution#getAuthor()
	 * @see #getContribution()
	 * @generated
	 */
	EReference getContribution_Author();

	/**
	 * Returns the meta object for the attribute '{@link org.odysseus.models.socialnetwork.activity.Contribution#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Contribution#getDate()
	 * @see #getContribution()
	 * @generated
	 */
	EAttribute getContribution_Date();

	/**
	 * Returns the meta object for class '{@link org.odysseus.models.socialnetwork.activity.Response <em>Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Response</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Response
	 * @generated
	 */
	EClass getResponse();

	/**
	 * Returns the meta object for the reference '{@link org.odysseus.models.socialnetwork.activity.Response#getPost <em>Post</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Post</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Response#getPost()
	 * @see #getResponse()
	 * @generated
	 */
	EReference getResponse_Post();

	/**
	 * Returns the meta object for enum '{@link org.odysseus.models.socialnetwork.activity.ReactionType <em>Reaction Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Reaction Type</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.ReactionType
	 * @generated
	 */
	EEnum getReactionType();

	/**
	 * Returns the meta object for enum '{@link org.odysseus.models.socialnetwork.activity.Visibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visibility</em>'.
	 * @see org.odysseus.models.socialnetwork.activity.Visibility
	 * @generated
	 */
	EEnum getVisibility();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActivityFactory getActivityFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.odysseus.models.socialnetwork.activity.impl.PostImpl <em>Post</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.models.socialnetwork.activity.impl.PostImpl
		 * @see org.odysseus.models.socialnetwork.activity.impl.ActivityPackageImpl#getPost()
		 * @generated
		 */
		EClass POST = eINSTANCE.getPost();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POST__TEXT = eINSTANCE.getPost_Text();

		/**
		 * The meta object literal for the '<em><b>Is Repost Of</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST__IS_REPOST_OF = eINSTANCE.getPost_IsRepostOf();

		/**
		 * The meta object literal for the '<em><b>Attached Media</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST__ATTACHED_MEDIA = eINSTANCE.getPost_AttachedMedia();

		/**
		 * The meta object literal for the '<em><b>Mentions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST__MENTIONS = eINSTANCE.getPost_Mentions();

		/**
		 * The meta object literal for the '<em><b>In Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST__IN_GROUP = eINSTANCE.getPost_InGroup();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POST__VISIBILITY = eINSTANCE.getPost_Visibility();

		/**
		 * The meta object literal for the '<em><b>Reactions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST__REACTIONS = eINSTANCE.getPost_Reactions();

		/**
		 * The meta object literal for the '<em><b>Comments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST__COMMENTS = eINSTANCE.getPost_Comments();

		/**
		 * The meta object literal for the '{@link org.odysseus.models.socialnetwork.activity.impl.ReactionImpl <em>Reaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.models.socialnetwork.activity.impl.ReactionImpl
		 * @see org.odysseus.models.socialnetwork.activity.impl.ActivityPackageImpl#getReaction()
		 * @generated
		 */
		EClass REACTION = eINSTANCE.getReaction();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REACTION__TYPE = eINSTANCE.getReaction_Type();

		/**
		 * The meta object literal for the '{@link org.odysseus.models.socialnetwork.activity.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.models.socialnetwork.activity.impl.CommentImpl
		 * @see org.odysseus.models.socialnetwork.activity.impl.ActivityPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '<em><b>In Response To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMENT__IN_RESPONSE_TO = eINSTANCE.getComment_InResponseTo();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENT__TEXT = eINSTANCE.getComment_Text();

		/**
		 * The meta object literal for the '{@link org.odysseus.models.socialnetwork.activity.impl.ContributionImpl <em>Contribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.models.socialnetwork.activity.impl.ContributionImpl
		 * @see org.odysseus.models.socialnetwork.activity.impl.ActivityPackageImpl#getContribution()
		 * @generated
		 */
		EClass CONTRIBUTION = eINSTANCE.getContribution();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRIBUTION__AUTHOR = eINSTANCE.getContribution_Author();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRIBUTION__DATE = eINSTANCE.getContribution_Date();

		/**
		 * The meta object literal for the '{@link org.odysseus.models.socialnetwork.activity.impl.ResponseImpl <em>Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.models.socialnetwork.activity.impl.ResponseImpl
		 * @see org.odysseus.models.socialnetwork.activity.impl.ActivityPackageImpl#getResponse()
		 * @generated
		 */
		EClass RESPONSE = eINSTANCE.getResponse();

		/**
		 * The meta object literal for the '<em><b>Post</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSE__POST = eINSTANCE.getResponse_Post();

		/**
		 * The meta object literal for the '{@link org.odysseus.models.socialnetwork.activity.ReactionType <em>Reaction Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.models.socialnetwork.activity.ReactionType
		 * @see org.odysseus.models.socialnetwork.activity.impl.ActivityPackageImpl#getReactionType()
		 * @generated
		 */
		EEnum REACTION_TYPE = eINSTANCE.getReactionType();

		/**
		 * The meta object literal for the '{@link org.odysseus.models.socialnetwork.activity.Visibility <em>Visibility</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.odysseus.models.socialnetwork.activity.Visibility
		 * @see org.odysseus.models.socialnetwork.activity.impl.ActivityPackageImpl#getVisibility()
		 * @generated
		 */
		EEnum VISIBILITY = eINSTANCE.getVisibility();

	}

} //ActivityPackage
